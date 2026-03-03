# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
        
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []
        def dfs(node, s):
            if not node.left and not node.right:
                s += str(node.val)
                res.append(s)
                s = ""
                # note that this is a leaf
            
            elif not node.left and node.right:
                s += f"{node.val}->"
                dfs(node.right, s)
            elif not node.right and node.left:
                s += f"{node.val}->"
                dfs(node.left, s)
            else:
                s += f"{node.val}->"
                dfs(node.left, s)
                dfs(node.right, s)
        dfs(root, "")
        return res