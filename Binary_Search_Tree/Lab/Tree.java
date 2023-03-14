import java.io.*;
/**a binary-search-tree container d oberle 10/2021.  */  
public class Tree
{
/** Data field: a reference to the first node of the tree. */
   private TreeNode myRoot;

/** No arg constructor initializes and empty tree. */   
   public Tree()
   {
      myRoot = null;
   }
   
/**Adds a new element to the tree such that the tree is still an ordered Binary Search Tree.
 * @param  x a non-null Comparable Object.
 */   
   public void add(Comparable x)
   {
      myRoot = addHelper(myRoot, x);
   }
  
/**Helper method for add(x).
 * @param   root is the root of a tree (or subtree for recursive calls). 
 * @param   x a non-null Comparable Object.   
 * @return  the root of the ordered binary search tree after x has been added.
 */    
   private TreeNode addHelper(TreeNode root, Comparable x)
   {
   
      if(root == null)
      {
         root = new TreeNode(x); 
         return root;
         
      }
      if(x.compareTo(root.getValue()) < 0)
         root.setLeft(addHelper(root.getLeft(), x));
      else
         root.setRight(addHelper(root.getRight(), x));// x is > than the root
      return root;
      
   }
   
/**Removes an element from the tree such that the tree is still an ordered Binary Search Tree.
 * @param  x a non-null Comparable Object.
 */   
   public void remove(Comparable x)
   {
      myRoot = removeHelper(myRoot, x);
   }
   
/**Helper method for remove(x).
 * @param   root is the root of a tree (or subtree for recursive calls).  
 * @param   x a non-null Comparable Object. 
 * @return  the root of the ordered binary search tree after x has been removed.
 */   
   private TreeNode removeHelper(TreeNode root, Comparable x)
   {
      if(root == null)
         return null;
      TreeNode d = searchHelper(root, x);
      TreeNode p = searchParent(root, x); //x is in THE root if p is null
      if(p == null)
         return root;
      if(isLeaf(d))
      {
         if(d == root)
            root = null;
         else if(d == p.getRight())
            p.setRight(null);
         else // d is a left child of p
            p.setLeft(null);    
      }
      else if(oneKid(d))
      {
         if(d == p.getLeft())
         {
            if(d.getLeft() != null)
               p.setLeft(d.getLeft());
            else//d must have right child
               p.setLeft(d.getRight());
         }
         else// d is right child of p
         {
            if(d.getLeft() != null)
               p.setRight(d.getLeft());
            else//d must have right child
               p.setRight(d.getRight());
         }
      }
      else//d has two kids
      {
         TreeNode m = d.getLeft(); //to find max value in d's left subtree
         while(m.getRight() != null)
            m = m.getRight();
         Comparable temp = m.getValue();
         removeHelper(root, temp);
         d.setValue(temp);
       
      }
      return root;
   }
   
/** Displays  the elements of the tree such that they are displayed in prefix order. */  
   public void showPreOrder()
   {
      preOrderHelper(myRoot);
      System.out.println();  
   }
   
/**Helper method for showPreOrder().
 * Because the process is recursive and needs to continue by sending subtrees as the next root to process.
 * @param   root is the root of a tree (or subtree for recursive calls).  
 */   
   private void preOrderHelper(TreeNode root)
   {
      if(root!=null)
      {
         System.out.print(root.getValue() + " "); 
         preOrderHelper(root.getLeft());   
         preOrderHelper(root.getRight());
      }
   }
   
/** Displays  the elements of the tree such that they are displayed in infix order. */ 
   public void showInOrder()
   {
      inOrderHelper(myRoot);
      System.out.println();
   }

/**Helper method for showInOrder().
 * Because the process is recursive and needs to continue by sending subtrees as the next root to process.
 * @param   root is the root of a tree (or subtree for recursive calls).  
 */   
   private void inOrderHelper(TreeNode root)   
   {
      if(root!=null)
      {
         inOrderHelper(root.getLeft());
         System.out.print(root.getValue() + " ");    
         inOrderHelper(root.getRight());
      }
   }
      
/** Displays  the elements of the tree such that they are displayed in postfix order. */ 
   public void showPostOrder()
   {
      postOrderHelper(myRoot);
      System.out.println();   
   }
   
/**Helper method for showPostOrder(). 
 * Because the process is recursive and needs to continue by sending subtrees as the next root to process.
 * @param   root is the root of a tree (or subtree for recursive calls).  
 */   
   private void postOrderHelper(TreeNode root)
   {
      if(root!=null)
      {
         postOrderHelper(root.getLeft());   
         postOrderHelper(root.getRight());
         System.out.print(root.getValue() + " "); 
      }
   }
   
/**Searches for an element in the tree.
 * @param   x a non-null Comparable Object.
 * @return  true if x is found; false if x is not found in the tree
 */    
   public boolean contains(Comparable x)
   {
      if (searchHelper(myRoot, x)==null)
         return false;
      return true;
   }

/**Helper method for contains(x).
 * Because  the process is recursive and needs to continue by sending subtrees as the next root to process.
 * @param   root is the root of a tree (subroots for recursive calls).
 * @param   x a non-null Comparable Object.
 * @return  a pointer to the TreeNode that contains the value x; returns null if not found
 */   
   private TreeNode searchHelper(TreeNode root, Comparable x)
   {
      if(root == null)
         return null;
      else if(x.compareTo(root.getValue()) == 0)
         return root;
      else if(x.compareTo(root.getValue()) < 0)
         return searchHelper(root.getLeft(), x);
      else // x is greater than root value
         return searchHelper(root.getRight(), x);
      
   }
   
/**Helper method for removeHelper(root, x).
 * Because  the process is recursive and needs to continue by sending subtrees as the next root to process.
 * @param   root is the root of a tree (subroots for recursive calls).
 * @param   x a non-null Comparable Object.
 * @return  a pointer to the parent of the node that contains the value x; returns null if not found
 */    
   private TreeNode searchParent(TreeNode root, Comparable x)
   {
      if(root == null)
         return null;
      else if(root.getLeft() != null && x.equals(root.getLeft().getValue()))
         return root;
      else if(root.getRight() != null && x.equals(root.getRight().getValue()))
         return root;
      else if(x.compareTo(root.getValue()) < 0)
      {
         return searchParent(root.getLeft(), x);
      }
      else
      {
         return searchParent(root.getRight(), x);
      }
   }
   
/**Helper method for removeHelper(root, x).
 * @param   root is the root of a tree.
 * @return  true if root has no children; returns false if root has 1 or 2 children
 */ 
   private boolean isLeaf(TreeNode root)
   {
      if(root == null)
         return false;
      else if(root.getLeft() == null && root.getRight() == null)
         return true;
      else
         return false;
   }
      
/**Helper method for removeHelper(root, x).
 * @param   root is the root of a tree.
 * @return  true if root has exactly one child; returns false if root has 0 or 2 children
 */
   private boolean oneKid(TreeNode root)
   {
      if(root == null)
         return false;
      else if(root.getLeft() != null && root.getRight() == null)//one child
         return true;
      else if(root.getRight() != null && root.getLeft() == null)//one child
         return true;
      else if(root.getLeft() != null && root.getRight() != null)//two child
         return false;
      else
         return false;//no child
         
   }
      
/**Returns the number of logical elements stored in the tree.
 * @return the number of nodes in the tree.
 */ 
   public int size()
   {
      return sizeHelper(myRoot);
   }
   
/**Helper method for size().
 * Because  the process is recursive and needs to continue by sending subtrees as the next root to process.
 * @param   root is the root of a tree (or subtree for recursive calls). 
 * @return  the size of the tree that starts at root 
 */    
   private int sizeHelper(TreeNode root)
   {
      if(root == null)
         return 0;
      int size = 1 + sizeHelper(root.getLeft()) + sizeHelper(root.getRight());
      return size;
       
   }

/**Returns the number of levels in the tree.  
 * An empty tree is height -1.  A 1-node tree is height 0.
 * A 2-node tree and a balanced 3-node tree are height 1.
 * @return the height/depth/number of levels of the tree.
 */          
   public int height()
   {
      return heightHelper(myRoot);
   }

/**Helper method for height().
 * Because  the process is recursive and needs to continue by sending subtrees as the next root to process.
 * @param   root is the root of a tree (or subtree for recursive calls). 
 * @return the height/depth/number of levels of the tree that starts at root.
 */   
   public int heightHelper(TreeNode root)
   {
      if(root == null)
         return -1;
      if(isLeaf(root))
         return 0;
      int leftHeight = heightHelper(root.getLeft());
      int rightHeight = heightHelper(root.getRight());
   //return 1 + large of the two heights
      return 1 + Math.max(leftHeight, rightHeight);
   }
   
/**EXTRA CREDIT: returns true if p is an ancestor of c.
 * @param   root is the root of a tree (or subtree for recursive calls). 
 * @param   p a non-null Comparable Object that can be found in the tree. 
 * @param   c a non-null Comparable Object that can be found in the tree.  
 * @return  true if p is an ancestor of c; return false if not or one/both can not be found in the tree.
 */    
   public boolean isAncestor(TreeNode root, Comparable p, Comparable c)
   {
   //************COMPLETE THIS METHOD*****************************   
      return false;     //temporary return statement to keep things compiling
   }
   
/**EXTRA CREDIT: displays all elements of the tree at a particular depth/level/height.
 * level 0 will show the root.  level 1 will show all elements that are children of the root.
 * A level that is less than 0 or greater than the max depth will display nothing.
 * @param   root is the root of a tree. 
 * @param   level is the depth in which you want to see all the elements of. 
 */ 
   public void printLevel(TreeNode root, int level)
   {
      
   }
 
/**Nothing to see here...move along.*/     
   private String temp;
/**Helper method for toString().
 * @param   root is the root of a tree (or subtree for recursive calls). 
 */ 
   private void inOrderHelper2(TreeNode root)   
   {
      if(root!=null)
      {
         inOrderHelper2(root.getLeft());
         temp += (root.getValue() + ", "); 
         inOrderHelper2(root.getRight());
      }
   }

/**Returns a String of all the elements in the tree in the form [a1, a2, a3, . . . , an] in order
 * @return String of all the in-oder tree elements separated by a comma
 */
   @Override
   public String toString()
   {
      temp="";
      inOrderHelper2(myRoot);
      if(temp.length() > 1)
         temp = temp.substring(0, temp.length()-2);
      return "[" + temp + "]";
   }
}