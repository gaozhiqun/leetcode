package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午4:21
 */
public class Leetcode_963_minAreaFreeRect {
    public static void main(String[] args) {

    }

    /**
     * 1 <= points.length <= 50
     * 0 <= points[i][0] <= 40000
     * 0 <= points[i][1] <= 40000
     */
    int N;

    public double minAreaFreeRect(int[][] points) {
        int  length = points.length;
        double minArea = Double.MAX_VALUE;

        for(int  i=0;i<length;i++){
            for(int  j=i+1;j<length;j++){
                for(int  k=j+1;k<length;k++){
                    for(int  m=k+1;m<length;m++){
                        double MidminArea = getMinArea(points,i,j,k,m);
                        if(MidminArea !=0) {
                            if(minArea>MidminArea)  minArea =MidminArea;
                            break;
                        }
                    }
                }
            }
        }

        return  minArea==Double.MAX_VALUE?0:minArea;
    }

    private  double  getMinArea(int[][] points,int i,int j,int k,int m){
        int[] x1 = new  int[2];
        int[] x2 = new  int[2];
        int[] x3 = new  int[2];
        x1[0] = points[j][0]-points[i][0];
        x1[1] = points[j][1]-points[i][1];
        x2[0] = points[k][0]-points[i][0];
        x2[1] = points[k][1]-points[i][1];
        x3[0] = points[m][0]-points[i][0];
        x3[1] = points[m][1]-points[i][1];



        double area = 0;
        if(x1[0]+x2[0]==x3[0] && x1[1]+x2[1]==x3[1] && x1[0]*x2[0]+x1[1]*x2[1]==0){
            area =  getxx(x1,x2);

        } else
        if(x3[0]+x2[0]==x1[0] && x3[1]+x2[1]==x1[1] && x3[0]*x2[0]+x3[1]*x2[1]==0){
            area =   getxx(x3,x2);

        }else
        if(x1[0]+x3[0]==x2[0] && x1[1]+x3[1]==x2[1] && x1[0]*x3[0]+x1[1]*x3[1]==0){
            area =  getxx(x3,x1);

        }

        return area;
    }

    private  double getxx( int[] a,int[] b){

        int  x = a[0] *b[1];
        int  y= a[1] *b[0];

        return Math.abs(x-y);
    }


}
