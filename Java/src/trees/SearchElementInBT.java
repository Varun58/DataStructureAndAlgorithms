package trees;

public class SearchElementInBT {

	public static boolean searchElement(TreeNode treeNode, int element) {

		if (treeNode == null) {
			return false;
		}

		if (treeNode.data == element) {
			return true;
		}

		return searchElement(treeNode.left, element) || searchElement(treeNode.right, element);
	}

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBT();
		System.out.println(searchElement(tree.root, 5));
		System.out.println(searchElement(tree.root, 1));
		System.out.println(searchElement(tree.root, 9));
		System.out.println(searchElement(tree.root, 12));
		System.out.println(searchElement(tree.root, 0));
	}
}
