package scut.carson_ho.shootatoffer;


/**
 * Created by Carson_Ho on 17/10/29.
 */

public class Exam_18 {


    /**
     * 执行解题算法
     */
    public static void main(String[] args) {

        /**
         * 删除节点 测试用例
         */
//        // 创建链表：1->2->3->4
//        Node<Integer> head = new Node<Integer>(1);
//        Node<Integer> node2 = new Node<Integer>(2);
//        Node<Integer> node3 = new Node<Integer>(3);
//        Node<Integer> node4 = new Node<Integer>(4);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//
//
//         // 功能测试：若删除的结点 = 链表中的结点 & 输出链表查看结果
//         head = deleteNode(head, node3);
//         while (head != null) {
//             System.out.print(head.val);
//             head = head.next;
//         }

        // 异常情况测试
        // 1. 若删除的结点 = 空 & 输出链表查看结果
        // head = deleteNode(head, null);
        // while (head != null) {
        //     System.out.print(head.val);
        //     head = head.next;
        // }


        // 2. 若删除的结点 = 头结点 & 输出链表查看结果
        // head = deleteNode(head, head);
        // while (head != null) {
        //     System.out.print(head.val);
        //     head = head.next;
        // }


        // 3. 若删除的结点 = 尾结点 & 输出链表查看结果
//        head = deleteNode(head, node4);
//        while (head != null) {
//            System.out.print(head.val);
//            head = head.next;
//        }


        /**
         * 删除重复节点 测试用例
         */
        // 创建链表：1->2->3->4
        Node<Integer> head = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(3);
        Node<Integer> node5 = new Node<Integer>(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // 功能测试：若删除的结点 = 链表中的结点 & 输出链表查看结果
         head = deleteDuplication(head);
         while (head != null) {
             System.out.print(head.val);
             head = head.next;
         }

    }

    /**
     * 题目：删除节点
     * @param head 链表头节点
     * @param node 要删除的节点
     */

    public static Node<Integer> deleteNode(Node<Integer> head,Node<Integer> node){


        // 如果输入的结点有空值就返回 表头结点
        if (head == null || node == null) {
            return head;

        }

        // 若删除的节点 = 头节点，直接返回头结点的下1个结点
        // 若 不采用返回值的方式，那么头结点永远删除不了
        if( node==head ){
            return head.next;
        }

        // 下面的情况 = 链表至少有2个结点

        // 情况1：若删除的是链表的尾结点
        if (node.next == null) {

            // 通过顺序查找 找到 待删除结点（尾结点）的前1个结点（前驱）
            Node tmp = head;
            while (tmp.next != node) {
                tmp = tmp.next;
            }
            // 删除待结点（尾结点）
            tmp.next = null;

        }
        // 情况2：若删除的是链表中间的结点
        else {
            // 将要删除的结点的下1个结点 覆盖 到 要删除的结点中
            node.val = node.next.val;
            // 将原要删除的结点的指针指向结点d的下1个结点（e）
            node.next = node.next.next;
        }

        // 返回删除节点后的链表的头结点
        return head;
    }

    /**
     * 题目：删除重复节点
     * @param head 链表头节点
     */

    public static Node<Integer> deleteDuplication(Node<Integer> head){

        // 1. 判断数据的合法性
        // 若输入的结点有空值就返回 表头结点
        if(head==null||head.next==null)
            return head;
        // 2. 定义3个节点：
        // pre :当前结点的前1结点
        // cur：当前结点（初始化 = 头结点）
        // pots：当前结点的后1结点
        Node<Integer> pre = null;
        Node<Integer> cur = head;
        Node<Integer> post = head.next;

        // 3. 设置需删除标记位
        boolean needDelete = false;

        // 4. 判断当前结点值 & 后1节点的值
        while (post!=null){
            // a. 若当前节点 与 后1节点的值相同
            if(cur.val.equals(post.val)){
                // 设置删除标记位
                needDelete = true;
                // 将后1节点的值更改为再后1节点的值
                post=post.next;
            }
            // b. 若当前节点 与 后1节点的值不相同 & 上1节点需删除
            else if(needDelete && !cur.val.equals(post.val)){
                // 考虑需删除的节点 = 头节点的情况
                if(pre == null)
                    head = post;
                // 若删除的节点不是头节点，则删除当前重复的2结点
                else
                    pre.next=post;
                cur = post;
                post = post.next;
                needDelete = false;
            }
            // b. 若当前节点 与 后1节点的值不相同
            // 将当前结点移到后1位继续比较（同时改变前1节点  & 后1节点）
            else{
                pre = cur;
                cur = post;
                post = post.next;
            }
        }
        // 异常情况1：若前1节点不为空 & 需删除节点，则设置为空
        if(needDelete && pre!=null)
            pre.next = null;
            // 异常情况1：若前1节点为空 & 需删除节点，则说明要删除的节点 = 头结点
        else if(needDelete && pre==null)
            head = null;
        return head;
    }


    /**
     * 设置结点结构
     */
    public static class Node<T> {
        T val;
        Node<T> next;

        public Node(T data) {
            this.val = data;
            this.next = null;
        }
    }

}





