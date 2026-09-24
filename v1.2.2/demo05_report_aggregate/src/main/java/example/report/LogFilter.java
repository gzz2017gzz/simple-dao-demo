package example.report;
import java.io.*;

public class LogFilter {
    public static void main(String[] args) {
        String inputFile = "d:/crm.log";
        String outputFile = "d:/FeaturesService.log";
        String keyword = "[FeaturesService.java:121]:对比耗时";

        // 使用 try-with-resources 自动关闭流
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    writer.write(line);
                    writer.newLine(); // 写入换行符
                }
            }

            System.out.println("提取完成，结果已保存到 " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("文件未找到: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("读写文件时出错: " + e.getMessage());
        }
    }
}