# Belajar-Spring-Dasar

Nama : Andi Muhammad Riffal<br>
Kelas : TEKOM 2B<br>
No BP : 2101082031<br>

# Sebelum Belajar

Memahami terlebih dahulu bahasa java untuk bisa memulai belajar menggunakan Spring Framework<br>

# Materi yang Akan di pelajari

- ApplicationContextTest<br>
- BeanFactoryTest<br>
- BeanNameTest<br>
- BeanPostProcessorTest<br>
- BeanTest<br>
- ComponentTest<br>
- CyclicTest<br>
- DatabaseTest<br>
- DependencyInjectionTest<br>
- DependsOnTest<br>
- DuplicateTest<br>
- FactoryTest<br>
- ImportTest<br>
- InheritanceTest<br>
- LifeCycleTest<br>
- OptionalTest<br>
- PrimaryTest<br>
- BelajarSpringDasarApplicationTests<br><br>

# Pengenalan Spring Framework
Spring Framework adalah sebuah framework yang paling populer di bahasa Java dan Saking populernya, Spring Framework sampai mengalahkan popularitas Java Enterprise sendiri Spring Framework dibuat sekitar tahun 2003 oleh Rod Johnson, yang dibuat sebagai alternative Java Enterprise, Spring Framework semakin populer karena sangat ringan dan mudah digunakan dibandingkan dengan Java Enterprise<br><br>
Beerikut adalah Link Spring Framework : https://spring.io/<br><br>

# Pengenalan Spring Boot
Spring Boot merupakan framework untuk mempermudah pembuatan aplikasi Spring Framework
Dahulu untuk menggunakan Spring Framework, untuk pemula tidaklah mudah, karena terlalu banyak yang harus dilakukan sebelum bisa membuat aplikasi
Spring Boot menjadikan kompleksitas tersebut ditangani secara otomatis oleh Spring Boot, sehingga kita bisa membuat aplikasi Spring Framework secara cepat tanpa harus melakukan pengaturan apapun
Spring Boot sekarang sudah menjadi salah satu framework wajib ketika kita ingin membuat aplikasi Spring Framework<br><br>

# ApplicationContext

ApplicationContext adalah sebuah interface representasi container IoC di Spring dan juga ApplicationContext adalah inti dari Spring Framework
ApplicationContext banyak sekali class implementasinya, secara garis besar dibagi menjadi 2 jenis implementasi, XML dan Annotation
Pada versi Spring 3, XML masih menjadi pilihan utama, namun sekarang sudah banyak orang beralih dari XML ke Annotation, bahkan Spring Boot pun merekomendasikan menggunakan Annotation untuk membuat aplikasi Spring<br><br>
javadoc ApplicationContext : <br>https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html<br><br>

***configuration***<br><br>
Untuk membuat ApplicationContext menggunakan Annotation, pertama kita bisa perlu membuat Configuration class
Configuration Class adalah sebuah class yang terdapat annotation @Configuration pada class tersebut

```java
@Configuration
public class HelloWorldConfiguration{
}
```
Selanjutnya, setelah membuat Class Configuration, kita bisa menggunakan class AnnotationConfigApplicationContext untuk membuat Application Context<br><br>
Berikut adalah link nya : <br>https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html<br><br>

# Singleton
Singleton adalah salah satu Design Patterns untuk pembuatan objek, dimana sebuah object hanya dibuat satu kali saja <br> <br>
Dan ketika kita membutuhkan object tersebut, kita hanya akan menggunakan object yang sama <br> <br>

```java
public class Database {
    private static Database database;
    
    public static Database getInstance(){
        if (database == null) {
            database = new Database();
        }
        return database;
    }
    
    private Database(){
        
    }
}
```

```java
    var database1 = Database.getInstance();
    var database2 = Database.getInstance();
    
    Assertions.assertSame(database1, database2);
```
# Bean
Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean <br> <br>
Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan object yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton, nanti akan kita bahas di materi tersendiri <br>
```java
@Configuration
public class BeanConfiguration {
    
    @Bean
    public Foo foo(){
        Foo foo = new Foo();
        log.info("Create new foo");
        return foo;
    }
}
```
# Primary Bean
Jika terjadi duplicate bean, selain kita sebutkan nama bean nya ketika ingin mengakses bean nya, kita  juga bisa pilih salah satu bean menjadi primary <br> <br>
Dengan memilih salah satunya menjadi primary, secara otomatis jika kita mengakses bean tanpa menyebutkan nama bean nya, secara otomatis primary nya yang akan dipilih <br> <br>
Untuk memilih primary bean, kita bisa tambahkan annotaiton @Primary <br> <br>
```java
    @Primary
    @Bean
    public Foo foo1(){
        return new Foo();
    }
    
    @Bean
    public Foo foo2(){
        return new Foo();
    }
```

# Mengubah Nama Bean
Secara default, nama bean diambil dari nama method <br> <br>
Namun kadang-kadang kita tidak ingin menggunakan nama method untuk nama bean
Saat project kita sudah besar, kadang bisa jadi nama method sama, walaupun isi bean nya berbeda, dan di Spring, nama bean itu unik, tidak boleh sama <br>
Jika kita ingin mengubah nama bean, kita bisa menggunakan method value() milik annotation @Bean <br> <br>

```java
    @Primary
    @Bean(name ="fooFirst")
    public Foo foo1(){
        return new Foo();
    }
    
    @Bean(name ="fooSecond")
    public Foo foo2(){
        return new Foo();
    }
```

# Dependency Injection
Saat kita membuat object, sudah pasti kita sering membuat object yang tergantung dengan object lain <br> <br>
Dependency Injection (DI) adalah teknik dimana kita bisa mengotomatisasi proses pembuatan object yang tergantung dengan object lain, atau kita sebut dependencies <br> <br>
Dependencies akan secara otomatis di-inject (dimasukkan) kedalam object yang membutuhkannya <br> <br>
Spring Framework sejak awal dibilang sebuah framework IoC yang memang cara kerjanya menggunakan Dependency Injection <br> <br>

```java
    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public FooBar fooBar(Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
```

# Memilih Dependency
Kadang saat menggunakan DI, kita ingin memilih object mana yang ingin kita gunakan <br> <br>
Saat terdapat duplicate bean dengan tipe data yang sama, secara otomatis Spring akan memilih bean yang primary <br> <br>
Namun kita juga bisa memilih secara manual jika memang kita inginkan <br> <br>
Kita bisa menggunakan annotation @Qualifier(value=”namaBean”) pada parameter di method nya <br> <br>

```java
    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
```

# Circular Dependencies
Hati-hati dengan curcular dependencies <br> <br>
Circular dependencies adalah kasus dimana sebuah lingkaran dependency terjadi, misal bean A membutuhkan bean B, bean B membutuhkan bean C, dan ternyata bean C membutuhkan A <br> <br>
Jika terjadi cyclic seperti ini, secara otomatis Spring bisa mendeteksinya, dan akan mengganggap bahwa itu adalah error <br> <br>

```java
    @Bean
    public CyclicA cyclicA(CyclicB cyclicB) {
        return new CyclicA(cyclicB);
    }

    @Bean
    public CyclicB cyclicB(CyclicC cyclicC) {
        return new CyclicB(cyclicC);
    }

    @Bean
    public CyclicC cyclicC(CyclicA cyclicA) {
        return new CyclicC(cyclicA);
    }
```

# Depends On
Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat <br> <br>
Namun bagaimana jika bean tersebut tidak membutuhkan bean lain, namun kita ingin sebuah bean dibuat setelah bean lain dibuat? <br> <br>
Jika ada kasus seperti itu, kita bisa menggunakan annotation @DependsOn(value={”namaBean”}) <br> <br>
Secara otomatis, Spring akan memprioritaskan pembuatan bean yang terdapat di DependsOn terlebih dahulu <br> <br>

```java
  @Bean
  @DependsOn({
      "bar"
  })
  public Foo foo(){
    log.info("Create new Foo");
    return new Foo();
  }

  @Bean
  public Bar bar(){
    log.info("Create new Bar");
    return new Bar();
  }
```

# Lazy Bean
Secara default, bean di Spring akan dibuat ketika aplikasi Spring pertama kali berjalan <br> <br>
Oleh karena itu, kadang ketika aplikasi Spring pertama berjalan akan sedikit lambat, hal ini dikarenakan semua bean akan dibuat di awal <br> <br>
Namun jika kita mau, kita juga bisa membuat sebuah bean menjadi lazy (malas), dimana bean tidak akan dibuat, sampai memang diakses atau dibutuhkan <br> <br>
Untuk membuat sebuah bean menjadi lazy, kita bisa tambahkan annotation @Lazy pada bean tersebut <br> <br>

```java
  @Lazy
  @Bean
  @DependsOn({
      "bar"
  })
  public Foo foo(){
    log.info("Create new Foo");
    return new Foo();
  }

  @Bean
  public Bar bar(){
    log.info("Create new Bar");
    return new Bar();
  }
```

# Scope
Scope merupakan strategy cara sebuah object dibuat <br> <br>
Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses, akan mengembalikan object yang sama <br> <br>
Namun kita juga bisa mengubah scope bean yang kita mau di Spring <br> <br>
Untuk mengubah scope sebuah bean, kita bisa tambahkan annotation @Scope(value=”namaScope”) <br> <br>

```java
  @Bean
  @Scope("prototype")
  public Foo foo(){
    log.info("Create new Foo");
    return new Foo();
  }
```

#  Membuat Scope 
Jika scope yang disediakan oleh Spring tidak bisa memenuhi kebutuhan kita, kita juga bisa membuat scope sendiri <br> <br>
Caranya dengan membuat class yang implement interface Scope <br> <br>

```java
  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    counter++;

    if(objects.size() == 2){
      int index = (int) (counter % 2);
      return objects.get(index);
    } else {
      Object object = objectFactory.getObject();
      objects.add(object);
      return object;
    }
  }

  @Override
  public Object remove(String name) {
    if(!objects.isEmpty()){
      return objects.remove(0);
    }
    return null;
  }
```

# Life Cycle
Spring Container memiliki alur hidup, dan jika kita ingin berinteraksi dengan alur hidup nya Spring, kita juga bisa lakukan <br> <br>
Saat pertama kali Spring berjalan dan sudah selesai membuat bean, Spring akan memberitahu bean tersebut bahwa bean tersebut sudah siap, artinya semua dependencies sudah dimasukkan. <br> <br>
Dan ketika aplikasi Spring akan mati, Spring juga akan memberitahu semua bean bahwa bean tersebut akan dihancurkan <br> <br>

### Connection Class

```java
@Slf4j
public class Connection implements InitializingBean, DisposableBean {

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("Connection is ready to be used");
  }

  @Override
  public void destroy() throws Exception {
    log.info("Connection is closed");
  }
}
```

### LifeCycle Configuration

```java
@Configuration
public class LifeCycleConfiguration {

  @Bean
  public Connection connection(){
    return new Connection();
  }
```




