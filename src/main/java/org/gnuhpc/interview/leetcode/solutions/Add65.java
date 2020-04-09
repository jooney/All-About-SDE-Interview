package org.gnuhpc.interview.leetcode.solutions;

/**
 * Copyright gnuhpc 2020/4/5
 */
/*
一. 十进制计算
大家都举5+7的例子。那我另想一个例子，计算十进制13+9：

1.计算不进位的和。十位1不变，个位3加9等于2，结果为12；
2.计算进位。十位没进位，个位进位为1，结果为10。

再计算十进制12+10：
1.计算不进位的和。十位1加1等于2，个位2加0等于2，结果为22；
2.计算进位。十位没进位，个位也没进位，结果为0。

因此结果13+9=22。

二. 二进制计算
13二进制为：1101，9二进制为：1001。

十进制是遇到大于等于10就保留余数，然后进位1。
那对应到二进制，就是遇到2就保留余数0，然后进位1。（二进制位之和不可能大于2）

计算二进制1101+1001：
1.计算不进位的和。从左到右，第1位为0，第2位为1，第3位为0，第4位为0，结果为0100；
2.计算进位。从左到右，第1位进位1，第2、3位没有进位，第4位进位1，结果为1001。不对，进位右边要补0，正确结果是10010。

计算二进制0100+10010：
1.计算不进位的和：10110；
2.计算进位：无。

因此结果为10110=22。

三.二进制加法公式

1）分析上面对二进制的计算过程，不难发现：
1.计算不进位的和，相当于对两个数进制异或：1101^1001=0100；
2.计算进位，第1位相当于对两个数求与：1101&1001=1001，然后再对其进行左移1位：1001<<1=10010。
然后再重复以上两个步骤。这里再异或一次就得到结果了，没进位：0100^10010=10110=22。

2）计算a+b，等价于(a^b)+((a&b)<<1)。
由于公式中又出现了+号，因此要再重复2）这个等价的计算过程。
结束条件是：没有进位了。

作者：ccav
链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/er-jin-zhi-qiu-he-chao-xiang-xi-da-bai-10000yong-h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Add65 {
    public int add(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;
        int plus1 = (a ^ b); // 求和（不计进位）. 相同位置0，相反位置1
        int plus2 = ((a & b) << 1); // 计算进位. 先保留同为1的位，都为1的位要向左进位，因此左移1位
        return add(plus1, plus2);
    }
}