import java.util.*;
import java.lang.Math;

/**
 * Random data.
 *
 * @author Tilda Jansson
 * @version 2021-03-17
 */

class SortingTestsRandom {
    public static void main(String[] args) {
        int warmup = 50;
        int times = 100;
        int runs = 70;
        
        IntSorter a = new InsertionSort();
        IntSorter b = new QuicksortFixedPivot();
        IntSorter c = new QuicksortRandomPivot();
        IntSorter d = new QuicksortFixedPivotInsertion();
        IntSorter e = new QuicksortRandomPivotInsertion();
        IntSorter f = new JavaSort();
        
        Data[] tests = {
            new Data(250, 100, Data.Order.RANDOM),
            new Data(500, 100, Data.Order.RANDOM),
            new Data(1000, 100, Data.Order.RANDOM),
            new Data(2000, 100, Data.Order.RANDOM),
            new Data(4000, 100, Data.Order.RANDOM),
            new Data(8000, 100, Data.Order.RANDOM),
            new Data(16000, 100, Data.Order.RANDOM),
            new Data(32000, 100, Data.Order.RANDOM),
        };
        
        Random random = new Random();
        
        ArrayList<ArrayList<String> > aList = new ArrayList<ArrayList<String>>(); //när >warmup, 
        ArrayList<ArrayList<String> > bList = new ArrayList<ArrayList<String>>(); //när >warmup, 
        ArrayList<ArrayList<String> > cList = new ArrayList<ArrayList<String>>(); //när >warmup, 
        ArrayList<ArrayList<String> > dList = new ArrayList<ArrayList<String>>(); //när >warmup, 
        ArrayList<ArrayList<String> > eList = new ArrayList<ArrayList<String>>(); //när >warmup, 
        ArrayList<ArrayList<String> > fList = new ArrayList<ArrayList<String>>(); //när >warmup, 

        for (int i = 0; i < runs; i++) { 
        
        ArrayList<String> resultsA = new ArrayList<>();
        ArrayList<String> resultsB = new ArrayList<>();
        ArrayList<String> resultsC = new ArrayList<>();
        ArrayList<String> resultsD = new ArrayList<>();
        ArrayList<String> resultsE = new ArrayList<>();
        ArrayList<String> resultsF = new ArrayList<>();        
        
        Stopwatch s = new Stopwatch();
    
        int sA, sB, sC, sD, sE, sF; ///
        
        for (Data t : tests) {
            sA = sB = sC = sD = sE = sF = 0; ///
            
            ArrayList<Long> tempA = new ArrayList<>();
            ArrayList<Long> tempB = new ArrayList<>();
            ArrayList<Long> tempC = new ArrayList<>();
            ArrayList<Long> tempD = new ArrayList<>();
            ArrayList<Long> tempE = new ArrayList<>();
            ArrayList<Long> tempF = new ArrayList<>();
 
            while(sA + sB + sC + sD + sE + sF < 6*times){
                int rand = random.nextInt(6)+1; //random mellan 1-6

                if(rand == 1 && sA < times){
                //A
                    s.start();
                    a.sort(t.get());
                    s.stop();
            
                    tempA.add(s.nanoseconds());
            
                    s.reset(); 
                    sA++;
                    
                    if (sA == times ){
                        long medel = Average(tempA, times);
                        //resultsA.add(arund(medel));
                        resultsA.add(String.valueOf(Math.round(medel)));
                    }
                }  
            
                if(rand == 2 && sB < times){
                //B
                    s.start();
                    b.sort(t.get());
                    s.stop();
            
                    tempB.add(s.nanoseconds());
            
                    s.reset();
                    sB++;
                    
                    if (sB == times ){
                        long medel = Average(tempB, times);
                        //resultsB.add(arund(medel));
                        resultsB.add(String.valueOf(Math.round(medel)));
                    }
                }
            
                if(rand == 3 && sC < times){
                //C
                    s.start();
                    c.sort(t.get());
                    s.stop();
            
                    tempC.add(s.nanoseconds());
            
                    s.reset();
                    sC++;
                    
                    if (sC == times ){
                        long medel = Average(tempC, times);
                        //resultsC.add(arund(medel));
                        resultsC.add(String.valueOf(Math.round(medel)));
                    }
                } 
            
                if(rand == 4 && sD < times){
                //D
                    s.start();
                    d.sort(t.get());
                    s.stop();
            
                    tempD.add(s.nanoseconds());
            
                    s.reset();
                    sD++;
                    
                    if (sD == times ){
                        long medel = Average(tempD, times);
                        //resultsD.add(arund(medel));
                        resultsD.add(String.valueOf(Math.round(medel)));
                    }
                }
            
                if(rand == 5 && sE < times){
                //E
                    s.start();
                    e.sort(t.get());
                    s.stop();
            
                    tempE.add(s.nanoseconds());
                
                    s.reset();
                    sE++;
                    
                    if (sE == times ){
                        long medel = Average(tempE, times);
                        //resultsE.add(arund(medel));
                        resultsE.add(String.valueOf(Math.round(medel)));
                    }
                }
            
                if(rand == 6 && sF < times){
                //F
                    s.start();
                    f.sort(t.get());
                    s.stop();
                
                    tempF.add(s.nanoseconds());
             
                    s.reset();
                    sF++;
                    
                    if (sF == times ){
                        long medel = Average(tempF, times);
                        //resultsF.add(arund(medel));
                        resultsF.add(String.valueOf(Math.round(medel)));
                    }
                }
            }

        }
        
        if(i > warmup-1){
            aList.add(resultsA);
            bList.add(resultsB);
            cList.add(resultsC);
            dList.add(resultsD);
            eList.add(resultsE);
            fList.add(resultsF);
        }
        
        System.out.println("InsertionSort Runtimes = " + resultsA);
        System.out.println("QuicksortFixedPivot Runtimes = " + resultsB);
        System.out.println("QuicksortRandomPivot Runtimes = " + resultsC);
        System.out.println("QuicksortFixedPivotInsertion Runtimes = " + resultsD);
        System.out.println("QuicksortRandomPivotInsertion Runtimes = " + resultsE);
        System.out.println("JavaSort Runtimes = " + resultsF);

        }
        
        System.out.println("!!!!!!!!Random Sample!!!!!!!!");
        System.out.println("InsertionSort Runtimes = " + aList.get(random.nextInt(aList.size())));
        System.out.println("QuicksortFixedPivot Runtimes = " + bList.get(random.nextInt(bList.size())));
        System.out.println("QuicksortRandomPivot Runtimes = " + cList.get(random.nextInt(cList.size())));
        System.out.println("QuicksortFixedPivotInsertion Runtimes = " + dList.get(random.nextInt(dList.size())));
        System.out.println("QuicksortRandomPivotInsertion Runtimes = " + eList.get(random.nextInt(eList.size())));
        System.out.println("JavaSort Runtimes = " + fList.get(random.nextInt(fList.size())));
    }
    
    private static long Average(ArrayList<Long> numb, long times) {
       long sum = 0;
       for(Long d : numb){
           sum += d;
       } 
       long average = sum/times;
       return average;
    }
}

