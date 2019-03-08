* Red Black Tree

> RB-Tree 의 조건

>- 1. 루트노드의 색깔은 Black
>- 2. 모든 external node들은 Black
>- 3. Red 노드의 자식은 Black
>- 4. 모든 leaf node에서 Black Depth는 같음(leaf node에서 root node까지 가는 경로에서 만나는 black node의 개수는 같다)


> RB-Tree는 항상 Double Red를 피해야함

> Restructing
>- 나(z)와 내 부모(v), 내 부모의 부모(gp)를 오름차순으로 정렬
>- 무조건 가운데 있는 값을 부모로 만들고 나머지 둘을 자식으로 만듬
>- 올라간 가운데 있는 값을 Black으로 만들고 나머지 두 자식을 Red로 만듬
>- Restructing은 다른 서브트리에 영향(Black Depth)을 끼치지 않아서 한번의 Restructing이면 끝남

> Recoloring
>- 현재 insert된 노드(z)의 부모(v)와 그 형제(w)를 Black으로 하고 gp는 Red로 함
>- gp가 root node가 아니었을 시 Double Red가 다시 발생 가능
>- 한번에 안끝날 가능성이 있음

> https://zeddios.tistory.com/237
> https://hamait.tistory.com/412






* HashTable

> 데이터 구조

>- (key - value) 쌍으로 저장하는 구조
>- key를 통해 바로 데이터를 받아오므로 속도가 획기적으로 빨라짐
>- python의 dictionary가 해쉬 테이블의 예
>- 보통은 배열로 미리 해쉬 테이블 사이즈 만큼 생성 후에 사용 (공간과 탐색 시간을 맞바꾸는 기법)
>- 단, python에서는 별도로 구현할 이유가 없음 (이미 dictionary 타입이 있기 때문)


> 용어

>- 해쉬 : 임의 값을 고정 길이로 변환하는 것
>- 해쉬 테이블 : 키 값의 연산에 의해 직접 접근히 가능한 데이터 구조
>- 해싱 함수 : key에 대해 산술 연산을 이용해 value 위치를 찾을 수 있는 함수
	      key를 해싱 함수로 연산해서, 해쉬 주소를 알아내고 이를 기반으로 해쉬 테이블에서 value를 얻어냄


> 장단점

>- 해쉬는 key에 대한 데이터 중복 확인이 쉬움
>- 여러 키에 해당하는 주소가 동일할 경우 충돌을 해결하기 위한 별도 자료구조가 필요함


> 좋은 해쉬 함수 사용하기

>- 충돌이 많은 해쉬 함수는 성능이 떨어짐
>- 주소에 키에 대한 데이터를 고루 분포시키는 함수(근래 SHA 함수 등이 많이 사용됨)


> 적합한 해쉬 테이블 사이즈

>- 해쉬 테이블 사용률 : 해쉬 테이블에 있는 항목의 수 / 해쉬 테이블에 있는 공간의 수
>- 보통 해쉬 테이블 사용률이 0.7 이상이면 해쉬 테이블 사이즈를 2배로 늘림

```
SHA-1
import hashlib
hash_object = hashlib.sha1()                      # 어떤 해쉬 알고리즘 쓸래?
hash_object.update(b'Hello World')                # 어떤 값을 해슁할 것인가?
hex_dig = hash_object.hexdigest()                 # 16진수로 해쉬값을 리턴해줌
print(hex_dig)
0a4d55a8d778e5022fab701977c5d840bbc486d0
```

```
SHA-256
import hashlib
hash_object = hashlib.sha256()                    # 어떤 해쉬 알고리즘 쓸래?
hash_object.update(b'Hello World')                # 어떤 값을 해슁할 것인가?
hex_dig = hash_object.hexdigest()                 # 16진수로 해쉬값을 리턴해줌
print(hex_dig)
a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e
```