package trees;

public class SearchElementInBT {

	public static boolean searchElement(Node node, int element) {

		if (node == null) {
			return false;
		}

		if (node.data == element) {
			return true;
		}

		return searchElement(node.left, element) || searchElement(node.right, element);
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
