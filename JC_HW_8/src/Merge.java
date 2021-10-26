//public class Merge extends Thread{
//    @Override
//    public void run(){
//        public static void merge(HollywoodMovie[] firstHalf,HollywoodMovie[] secondHalf,HollywoodMovie[] sortedArray){
//            int firstArrayIndex =0;
//            int secondArrayIndex=0;
//            int sortedArrayIndex =0;
//
//
//            while(firstArrayIndex<firstHalf.length && secondArrayIndex<secondHalf.length){
//                if(firstHalf[firstArrayIndex].getYear() < secondHalf[secondArrayIndex].getYear() ){
//                    sortedArray[sortedArrayIndex]=firstHalf[firstArrayIndex];
//
//                    firstArrayIndex++;
//                    sortedArrayIndex++;
//                }else{
//                    sortedArray[sortedArrayIndex]=secondHalf[secondArrayIndex];
//
//                    secondArrayIndex++;
//                    sortedArrayIndex++;
//
//                }
//            }
//
//            while (firstArrayIndex<firstHalf.length){
//                sortedArray[sortedArrayIndex]=firstHalf[firstArrayIndex];
//
//                firstArrayIndex++;
//                sortedArrayIndex++;
//            }
//
//            while ( secondArrayIndex<secondHalf.length){
//                sortedArray[sortedArrayIndex]=secondHalf[secondArrayIndex];
//
//                secondArrayIndex++;
//                sortedArrayIndex++;
//            }
//    }
//}
