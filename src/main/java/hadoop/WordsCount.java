package hadoop;

import org.apache.avro.mapreduce.AvroKeyValueOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.Iterator;

/**
 * @program: spark_test
 * @package: hadoop
 * @filename: WordsCount.java
 * @create: 2020/07/19 17:11
 * @author: 29314
 * @description: .词频统计
 **/

public class WordsCount extends Configured implements Tool {
    static class myMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
        private Text word = new Text();
        private IntWritable num = new IntWritable();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] words = value.toString().split(" ");
            for(String w: words){
                word.set(w);
                num.set(1);
                context.write(word,num);
            }
        }
    }

    static class myReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
        private IntWritable num = new IntWritable();

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int n = 0;
            Iterator<IntWritable> iterator = values.iterator();
            while(iterator.hasNext()){
                n = n + iterator.next().get();
            }
            num.set(n);
            context.write(key,num);
        }
    }

    @Override
    public int run(String[] strings) throws Exception {
        Configuration conf = this.getConf();

        Path in = new Path(conf.get("in"));
        Path out = new Path(conf.get("out"));

        Job job = Job.getInstance(conf, "WordsCount");
        job.setJarByClass(this.getClass());

        job.setMapperClass(myMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setInputFormatClass(FileInputFormat.class);
        FileInputFormat.addInputPath(job,in);

        job.setReducerClass(myReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(AvroKeyValueOutputFormat.class);
        AvroKeyValueOutputFormat.setOutputPath(job,out);
        
        return job.waitForCompletion(true)?0:1;
    }

    public static void main(String[] args) throws Exception {
        System.exit(ToolRunner.run(new WordsCount(),args));
    }
}
