import java.util.Arrays;

public class infnumber {
    public static void main(String[] args) {
        // 测试--产生2000个在0-10000范围内的无重复的随机数
        int num = 2000;
        int scope = 10000;// 即取[0,10000)中的整数
        // 创建随机数组：直接赋值随机数
        int[] numArray = new int[num];
        for (int i : numArray) {
            i = (int) (Math.random() * scope);
        }
        int[] test3Arr = isEqual(numArray, scope);

        System.out.println("测试结果：" + Arrays.toString(test3Arr));
        Arrays.sort(test3Arr);
        System.out.println("第1023小的数为：" + test3Arr[1023]);
    }

    // 递归直接取值
    private static int[] isEqual(int[] numArray, int scope) {
        // 获得随机数
        int random = (int) (Math.random() * scope);

        // 给数组赋值---外层：给数组元素依次赋值
        for (int i = 1; i <= numArray.length - 1; i++) {
            // 内层：每次赋值后，与前面的数值进行比较，是否有重复

            // 若重复，就重新生成随机数赋值---若无重复，就给下一个数赋值
            for (int j = 0; j <= i - 1; j++) {
                // 判断是否有重复
                if (numArray[i] == numArray[j]) {
                    // 有重复就重新赋值
                    numArray[i] = random;
                    // 对新赋的值，进行判断
                    isEqual(numArray, scope);

                    break;
                }
            }
        }
        return numArray;
    }
}
