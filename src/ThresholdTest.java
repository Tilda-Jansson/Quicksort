import java.util.*;
import java.util.Collections;
import java.lang.Math;
/**
 * Test to find the optimal cut-off to insertion sort.
 *
 * @author Tilda Jansson
 * @version  2021-03-17
 */
class ThresholdTest{
    public static void main(String[] args) {
       ArrayList<Integer> AcutOffs = new ArrayList<>();
       ArrayList<Integer> BcutOffs = new ArrayList<>();
       
       int warmup = 30;
       int runs = 50;
       for (int i = 0; i < runs; i++) {
        int thresholds = 120;
        
        Threshold a = new QsFixedPivotInsertion();
        Threshold b = new QsRandomPivotInsertion();

        Data[] tests = {
            new Data(1000000, 100, Data.Order.RANDOM),
        };
        ArrayList<String> aresults = new ArrayList<String>();
        ArrayList<String> bresults = new ArrayList<String>();
                
        ArrayList<Integer> anumresults = new ArrayList<>();
        ArrayList<Integer> bnumresults = new ArrayList<>();
        
         
            for (int threshold = 0; threshold < thresholds+1; threshold++){ 

                Stopwatch s = new Stopwatch();
                
                s.start();
                a.sort(tests[0].get(), threshold);
                s.stop();
                aresults.add(String.valueOf(s.nanoseconds()));
                anumresults.add(Math.round(s.nanoseconds()));
                s.reset();
            
                s.start();
                b.sort(tests[0].get(), threshold);
                s.stop();
                bresults.add(String.valueOf(s.nanoseconds()));
                bnumresults.add(Math.round(s.nanoseconds()));
                s.reset();
                
                if(threshold == thresholds){
                    
                    System.out.println("!!!!!!!!!"+i+"!!!!!!!!!");
                    System.out.println("QsFixedPivotInsertion runtimes = " + aresults);
                    System.out.println("QsRandomPivotInsertion runtimes = " + bresults);
                    
                    int AminIndex = anumresults.indexOf(Collections.min(anumresults));
                    int BminIndex = bnumresults.indexOf(Collections.min(bnumresults));
                    
                    System.out.println("QsFixedPivotInsertion minimum time:"+aresults.get(AminIndex) + "; Threshold:"+AminIndex);
                    System.out.println("QsRandomPivotInsertion minimum time:"+bresults.get(BminIndex) + "; Threshold:"+BminIndex);
                    
                    if(i>warmup-1){
                        AcutOffs.add(AminIndex);
                        BcutOffs.add(BminIndex);
                    }
                }
                
            }
            
        }
        int AmedelCutOff = Average(AcutOffs, runs-warmup);
        int BmedelCutOff = Average(BcutOffs, runs-warmup);
        System.out.println("QsFixedPivotInsertion, medel cut-off : "+AmedelCutOff);
        System.out.println("QsRandomPivotInsertion, medel cut-off : "+BmedelCutOff);
        
    }  
   
    private static int Average(ArrayList<Integer> numb, int times) {
       int sum = 0;
       for(int d : numb){
           sum += d;
       } 
       int average = sum/times;
       return average;
    }


}


