package ArraysLeet.Medium.tree;

import java.util.HashMap;

public class TreeFromInOrderAndPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pre[] = new int[] { -1 };
		int in[] = new int[] { -1 };

		TreeNode root = buildTree(in, pre);
		printInorder(root);
	}

	private static TreeNode buildTree(int[] inorder, int[] preorder) {
		HashMap<Integer, Integer> hm = makeHashMap(inorder);
		return buildTree(inorder, preorder, 0, inorder.length - 1, hm);
	}

	static int preIndex = 0;

	static TreeNode buildTree(int inorder[], int preorder[], int inStrt, int inEnd, HashMap<Integer, Integer> hm) {
		if (inStrt > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preIndex++]);
		if (inStrt == inEnd)
			return root;
		int index = hm.getOrDefault(root.val, 0);
		root.left = buildTree(inorder, preorder, inStrt, index - 1, hm);
		root.right = buildTree(inorder, preorder, index + 1, inEnd, hm);
		return root;
	}

	static void printInorder(TreeNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	private static HashMap<Integer, Integer> makeHashMap(int[] inorder) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			hm.put(inorder[i], i);
		}
		return hm;
	}

}
