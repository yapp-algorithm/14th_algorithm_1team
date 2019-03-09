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

> 이진트리를 확장해서 더 많은 수의 자식을 가질 수 있게 일반화
> 자식 수에 대한 일반화를 하면서 하나의 레벨에 더 많이 저장되는 것 뿐만 아니라 트리의 균형을 자동으로 맞추는 로직까지 갖춤
> 균형 로직이 단순하면서도 효율적
> 한 노드에 M개의 자료가 배치되면 M차 B-Tree라고 함
>- 5차 B-Tree인 경우, 자식노드가 최대 5개인 것을 의미
>- B-Tree는 스스로 균형을 맞추는 트리이기 때문에 최악의 경우에도 O(logN)의 검색 성능을 보임

> 대량의 데이터를 처리해야 하는 검색 구조인 경우, 하나의 노드가 많은 데이터를 가지는건 큰 장점
> 대량의 데이터는 메모리 보다는 HDD or SSD에 저장되어야 하는데, 이것들은 블럭 단위로 입출력을 하기 때문
> 예시
>- 한 블럭이 1024byte 라면 2byte를 읽으나 1024byte를 읽으나 입출력에 대한 비용은 동일
>- 그렇다면 하나의 노드를 1024byte가 되도록 조절한다면 입출력 면에서 매우 효율적인 구성
>- 이런 장점으로 많은 DBS의 인덱스 저장 방법으로 애용되고 있음

> 규칙
>- 노드의 자료수가 N이라면 자식의 수는 N+1이어야 한다
>- 각 노드의 자료는 정렬된 상태여야 한다
>- 노드의 자료Dk의 왼쪽 서브트리는 Dk보다 작은 값들이고 오른쪽 서브트리는 Dk보다 큰 값들이어야 한다
>- Root 노드는 적어도 2개이상의 자식을 가져야 한다
>- Root 노드를 제외한 모든 노드는 적어도 M/2개의 자료를 가지고 있어야 한다
>- 외부 노드(leaf node)로 가는 경로의 길이는 모두 같다(외부노드는 모두 같은 레벨에 있다)
>- 입력자료는 중복될 수 없다

> B-Tree의 삽입
>- 새로운 원소는 leaf node에 삽입
>- node에 overflow가 발생되면 노드의 t-1번째 key(중간값)를 parent로 올리고 노드를 분할

> B-Tree의 삭제
>- 삭제 대상은 모든 node의 원소
>- 다만, 삭제를 하기 위헤서는 leaf node로 해당 원소를 이동시켜야 함
>- https://potatoggg.tistory.com/174
