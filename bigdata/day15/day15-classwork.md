
### WordCount -- Map-Reduce Program -- Pseudo code (Java)
* WordCountMapper
    ```java
    class WordCountMapper {
        // map() called once for each record
        void map(long offset, String line, Context ctx) {
            String lowerLine = line.toLowerCase();
            String[] words = lowerLine.split("[^a-z]");
            for(String word: words)
                ctx.write(word, 1);
        }
    }
    ```
* WordCountReducer
    ```java
    class WordCountReducer {
        // reduce() called once for each group
        void reduce(String word, Iterable<Integer> counts, Context ctx) {
            int total = 0;
            for(int cnt: counts)
                total = total + cnt;
            ctx.write(word, total);
        }
    }
    ```

### Hadoop MR Job
* Hadoop wrapper types -- for efficient network transfer
    * byte -- ByteWritable
    * short -- ShortWritable
    * int -- IntWritable
    * long -- LongWritable
    * float -- FloatWritable
    * double -- DoubleWritable
    * boolean -- BooleanWritable
    * String -- Text
    * null -- NullWritable
    * arrays -- ArrayWritable
    * maps -- MapWritable
* Primitive type <--> Wrapper type
    ```Java
    int x = 123;

    IntWritable xwr1 = new IntWritable(x);
    // OR
    IntWritable xwr2 = new IntWritable();
    xwr2.set(x);

    int i = xwr1.get();
    ```
    ```Java
    String x = "Nilesh";

    Text xwr = new Text(x);

    String s = xwr.toString();
    ```
* To writer mapper class, it must be inherited from "Mapper<>" class and should override its map() method.
    * `Map<KeyIn, ValueIn, KeyOut, ValueOut>`
* To writer reducer class, it must be inherited from "Reducer<>" class and should override its reduce() method.
    * `Reducer<KeyIn, ValueIn, KeyOut, ValueOut>`

### WordCount -- Map-Reduce Program -- Hadoop code
* WordCountMapper
    ```java
    public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        // map() called once for each record
        void map(LongWritable offset, Text line, Mapper.Context<> ctx) {
            String str = line.toString();
            String lowerLine = str.toLowerCase();
            String[] words = lowerLine.split("[^a-z]");
            for(String word: words)
                ctx.write(new Text(word), new IntWritable(1));
        }
    }
    ```
* WordCountReducer
    ```java
    class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        // reduce() called once for each group
        void reduce(Text word, Iterable<IntWritable> counts, Reducer.Context<> ctx) {
            int total = 0;
            for(IntWritable cnt: counts)
                total = total + cnt.get();
            ctx.write(word, new IntWritable(total));
        }
    }
    ```
* Driver class
* Run command
    > hadoop jar /path/of/mr1-wordcount-0.0.1-SNAPSHOT.jar com.sunbeam.MR01Main
