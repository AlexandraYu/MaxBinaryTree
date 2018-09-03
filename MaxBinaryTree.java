class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class MaxBinaryTree {
    //the function requires the array, and the boundaries of the sub-array used to construct the left tree and right tree
    public static TreeNode constructMaximumBinaryTree(int[] nums, int leftBound, int rightBound) {
        int maxIndex=leftBound; 
        if (leftBound>rightBound) return null; //when there's no more "element" in the subarray left, meaning the subarray becomes so smal that it eventually becomes none, it's time to return null
        for(int i = leftBound; i <= rightBound; i++) { //here we try to find the index of the maximum element in the array
            if(nums[i] > nums[maxIndex]) maxIndex = i; 
        }
        TreeNode node = new TreeNode(nums[maxIndex]); //construct the tree with the maximum element from the array 
        //here, using index of the maximum element as a separator, we construct the left tree with the left part of the array, and right tree with the right part of the array
        //we repeat this method with new "separator" which dictates our left and right boundaries, until there's no subarray left
        node.left = constructMaximumBinaryTree(nums, leftBound, maxIndex-1);
        node.right = constructMaximumBinaryTree(nums, maxIndex+1, rightBound);
        return node; 
    }
    private static void printTree(TreeNode treeHead) {
        if(treeHead==null) return;
        //we use pre-order traveral to print the tree (root, left, right)
        System.out.print("preorder: "+treeHead.val+"\n");
        printTree(treeHead.left);
        printTree(treeHead.right); 
		
    }
    public static void main (String[] args) {
        int array[] = {3,2,1,6,0,5};
        TreeNode  myNode; 
        myNode=constructMaximumBinaryTree (array, 0, array.length-1);
        printTree(myNode);
        
    }
}