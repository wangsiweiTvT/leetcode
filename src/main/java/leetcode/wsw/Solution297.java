package leetcode.wsw;

import java.io.Serializable;
import java.sql.PseudoColumnUsage;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private  class Point {

        public int i;

    }

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.left=treeNode2;
//        treeNode1.right=treeNode3;
//        String serialize = new Solution297().serialize(treeNode1);
//        String[] split = serialize.split(",");
//        System.out.println(split.length);
//        System.out.println(serialize);

        Integer integer = new Integer(1);
        Integer i = 500;
        inte(integer);
        System.out.println(integer);


    }

    public static void inte(Integer integer) {

        integer++;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {


        if (root == null) return "X,";

        return root.val + "," + serialize(root.left) + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] split = data.split(",");


        Point point = new Point();
        return helpDeserialize(split, point);
    }

    public TreeNode helpDeserialize(String[] data, Point pos) {

        //if (pos.i>=data.length)return null;
        if (data[pos.i].equals("X")) {
            pos.i++;
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(data[pos.i]));
        pos.i++;
        treeNode.left = helpDeserialize(data, pos);
        treeNode.right = helpDeserialize(data, pos);
        return treeNode;
    }


}
