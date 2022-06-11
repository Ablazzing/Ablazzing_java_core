package lesson1;

import java.util.Arrays;

public class HomeworkAdvancedErrors {
    public static void main(String[] args) {

        /* Усложнение кода, использование не нужных классов */
        // Вместо
        int[] nums1 = {1, 2, 5, 7, 10};
        int[] nums2 = {2, 3, 2, 17, 15};
        int[] numsFusion = new int[nums1.length + nums2.length]; // length = 10
        int[] numsMultiplied = new int[nums1.length]; // length = 5
        int[] numsResult = new int[numsFusion.length + nums1.length]; // length = 15;

        System.arraycopy(nums1, 0, numsFusion, 0, nums1.length);
        System.arraycopy(nums2, 0, numsFusion, nums1.length, nums2.length);
        System.arraycopy(numsFusion, 0, numsFusion, 0, numsFusion.length);

        for (int i = 0; i < nums1.length; i++)
            numsMultiplied[i] = nums1[i] * nums2[i];


        System.arraycopy(numsFusion, 0, numsResult, 0, numsFusion.length);
        System.arraycopy(numsMultiplied, 0, numsResult, numsFusion.length, numsMultiplied.length);
        System.arraycopy(numsResult, 0, numsResult, 0, numsResult.length);

//        System.out.println(Arrays.toString(numsResult) + "\n");
        // Надо
        int[] mynums1 = {1, 2, 5, 7, 10};
        int[] mynums2 = {2, 3, 2, 17, 15};
        int[] mynums3 = new int[15];

        for (int i = 0; i < 5; i++) {
            mynums3[i] = mynums1[i];
        }

        for (int i = 0; i < mynums1.length; i++) {
            mynums3[i+5] = mynums2[i];
        }

        for (int i = 0; i < mynums2.length; i++) {
            mynums3[i+10]  = mynums1[i] * mynums2[i];

            mynums3[10] = 1 * 2;
            mynums3[14] = 10 * 15;
        }

        for (int i = 0; i < mynums3.length; i++) {
            System.out.print(mynums3[i] + " ");
        }
        System.out.println();

        /* Использование лишнего форматирования */
        //Вместо
        int a = 3;
        int b = 5;
        System.out.printf("%.0f", Math.pow((a+b), 2));
        System.out.println("");

        // Надо
        System.out.println( Math.pow((a+b), 2));


        // Отсчет в substring идет тоже от нуля до определенного индекса (не учитывая его), поэтому первые 8 символов
        // Вместо
        System.out.println("123456789".substring(0,7));
        // Надо
        System.out.println("123456789".substring(0,8));

        int[] array = {1,2};
        int[] array1 = {0,0};
        int num = 1;
        num = 50;
        for (int num2: array) {
            array1[0] = num2;
        }
    }
}
