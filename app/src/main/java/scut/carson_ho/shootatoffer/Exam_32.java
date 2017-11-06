package scut.carson_ho.shootatoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Carson_Ho on 17/11/6.
 */

public class Exam_32 {


    /**
     * 测试用例
     */

    public static void main(String[] args){
        // 功能测试
        System.out.println("功能测试");
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        TreeNode<Integer> root = new TreeNode<Integer>(8);
        root.leftNode = new TreeNode<Integer>(6);
        root.rightNode = new TreeNode<Integer>(10);
        root.leftNode.leftNode = new TreeNode<Integer>(5);
        root.leftNode.rightNode = new TreeNode<Integer>(7);
        root.rightNode.leftNode = new TreeNode<Integer>(9);
        root.rightNode.rightNode = new TreeNode<Integer>(11);
        levelTravel(root);

        // 特殊输入测试：头节点为空、只有1个节点的二叉树
        System.out.println("特殊输入测试");
        levelTravel(null);

        TreeNode<Integer> root1 = new TreeNode<Integer>(8);
        levelTravel(root1);

    }

    /**
     * 结点结构
     */
    public static class TreeNode<T> {
        T val; // 二叉树的结点数据
        TreeNode<T> leftNode; // 二叉树的左子树（左孩子）
        TreeNode<T> rightNode; // 二叉树的右子树（右孩子）

        public TreeNode(T data) {
            this.val = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    /**
     * 内容：层序遍历
     * 方式：非递归（采用队列）
     */
    public static void levelTravel(TreeNode root){
        // 创建队列
        Queue<TreeNode> q=new LinkedList<TreeNode>();

        // 步骤1：判断当前结点是否为空；若是，则返回空操作
        if(root==null) {
            System.out.println("输入的头节点为空");
            return;
        }
        // 步骤2：入队当前结点
        q.add(root);

        // 步骤3：判断当前队列是否为空，若为空则跳出循环
        while(!q.isEmpty()){

            // 步骤4：出队队首元素
            root =  q.poll();

            // 步骤5：输出 出队元素
            System.out.println(root.val);

            // 步骤5：若出队元素有左孩子，则入队其左孩子
            if(root.leftNode!=null) q.add(root.leftNode);

            // 步骤6：若出队元素有右孩子，则入队其右孩子
            if(root.rightNode!=null) q.add(root.rightNode);
        }
    }


}