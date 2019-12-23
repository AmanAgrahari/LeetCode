package ArraysLeet.Medium.tree;

import java.util.HashMap;

public class TreeFromInOrderAndPostOrder {

	static int n = 0;
	public static void main(String[] args) {
		int in[] = new int[] {-1};
		int post[] = new int[] {-1 };

		TreeNode root = buildTree(in, post);
		printInorder(root);
	}

	private static TreeNode buildTree(int[] inorder, int[] postorder) {
		n = postorder.length-1;
		HashMap<Integer, Integer> hm = makeHashMap(inorder);
		return buildTree(inorder, postorder, 0, inorder.length - 1, hm);
	}

	private static TreeNode buildTree(int[] inorder, int[] postorder, int start, int end,
			HashMap<Integer, Integer> hm) {
		if (start > end)
			return null;

		TreeNode root = new TreeNode(postorder[n]);
		n--;

		if (start == end)
			return root;

		int index = hm.get(root.val);

		root.right = buildTree(inorder, postorder, index + 1, end, hm);
		root.left = buildTree(inorder, postorder, start, index - 1, hm);

		return root;
	}

	private static HashMap<Integer, Integer> makeHashMap(int[] inorder) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			hm.put(inorder[i], i);
		}
		return hm;
	}
	
	static void printInorder(TreeNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

}
