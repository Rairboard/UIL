import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Remy {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("remy.dat"));

        int reqCount = 0;
        Map<String,Integer> ipCounts = new HashMap<>();
        int errCount = 0;
        Map<String,Integer> urlCounts = new HashMap<>();

        while(input.hasNext()){
            String[] line = input.nextLine().split(" ");
            reqCount++;
            String ip = line[2];
            ipCounts.put(ip,ipCounts.getOrDefault(ip,0)+1);
            if(line[5].charAt(0)=='4'||line[5].charAt(0)=='5'){
                errCount++;
            }
            String url = line[4];
            urlCounts.put(url,urlCounts.getOrDefault(url,0)+1);
        }
        int maxCount = 0;
        String ip = "";
        for(String i:ipCounts.keySet()){
            if(ipCounts.get(i)>maxCount){
                maxCount = ipCounts.get(i);
                ip = i;
            }
        }
        maxCount = 0;
        String url = "";
        for(String i:urlCounts.keySet()){
            if(urlCounts.get(i)>maxCount){
                maxCount = urlCounts.get(i);
                url = i;
            }
        }
        System.out.println("Total requests: " + reqCount);
        System.out.println("Unique IP addresses: " + ipCounts.size());
        System.out.println("Most frequent IP address: " + ip + " ("+ ipCounts.get(ip) + " requests)");
        System.out.println("Error rate: " + String.format("%.2f",(100.0*(double)errCount/reqCount))+"%");
        System.out.println("Most requested URL: " + url + " ("+ urlCounts.get(url)+" requests)");

    }
}
