* Binary Tree

> 이진트리는 각 노드가 자식노드를 최대 2개 가지는 트리를 의미
> 편향 이진트리, 완전 이진트리, 포화 이진트리 가 존재
> 깊이 우선 순회
>- 전위순회 : root -> left -> right순으로 순회
```
    def pre_order_traversal(self):
        def _pre_order_traversal(root):
            if root is None:
                pass
            else:
                print(root.data)
                _pre_order_traversal(root.left)
                _pre_order_traversal(root.right)
        _pre_order_traversal(self.root)
```
>- 중위순회 : left -> root -> right순으로 순회
```
    def in_order_traversal(self):
        def _in_order_traversal(root):
            if root is None:
                pass
            else:
                _in_order_traversal(root.left)
                print(root.data)
                _in_order_traversal(root.right)
        _in_order_traversal(self.root)
```
>- 후위순회 : left -> right -> root순으로 순회
```
    def post_order_traversal(self):
        def _post_order_traversal(root):
            if root is None:
                pass
            else:
                _post_order_traversal(root.left)
                _post_order_traversal(root.right)
                print(root.data)
        _post_order_traversal(self.root)
```

> 너비 우선 순회
>- 레벨 순회 : 맨 위 root node부터 깊이 순으로 방문
```
    def level_order_traversal(self):
        def _level_order_traversal(root):
            queue = [root]
            while queue:
                root = queue.pop(0)
                if root is not None:
                    print(root.data)
                    if root.left:
                        queue.append(root.left)
                    if root.right:
                        queue.append(root.right)
        _level_order_traversal(self.root)
```




* B-Tree
