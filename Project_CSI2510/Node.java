class Node:
   def __init__(self, data):
       self.data = data
       self.left = None
       self.right = None

def inOrder(root):
   current_node = root
   T = []
   done = 0
   while True:
       if current_node is not None:
           T.append(current_node)
           current_node = current_node.left
       elif(T):
           current_node = T.pop()
           print(current_node.data, end=" ")
           current_node = current_node.right
       else:
           break
   print()

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
inOrder(root)