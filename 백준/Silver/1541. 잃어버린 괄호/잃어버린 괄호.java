import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sb = bf.readLine().split("-");
        int res = 0 ;

        for(int i=0;i<sb.length;i++){
            int temp=0;

            String[] add = sb[i].split("\\+");

            for(int j=0;j<add.length;j++){
                temp+= Integer.parseInt(add[j]);
            }
            if(i==0){
                res += temp;
            }else{
                res -= temp;
            }
        }
        System.out.println(res);
    }
}