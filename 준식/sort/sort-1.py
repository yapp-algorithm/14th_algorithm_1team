def selection_sort(array) :
    length = len(array)
    for i in range(0,length-1) :
        min = i
        for j in range(i+1,length) :
            if(array[j] < array[min]) :
                min = j
        array[i] , array[min] = array[min] , array[i]

def bubble_sort(array) :
    length = len(array)
    for i in range(0,length-1) :
        for j in range(i+1,length) :
            if(array[i] > array[j]) :
                array[i], array[j] = array[j], array[i]


def insertion_sort(array) :
    length = len(array)
    for i in range(1, length):
        for j in range(i, 0, -1) :
            if(array[j] < array[j-1]) :
                array[j], array[j-1] = array[j-1], array[j]


def solution(array, commands):
    answer = []

    for command in commands :
        start, end, k = command
        array_tmp = array[start-1:end]
        selection_sort(array_tmp)
        #bubble_sort(array_tmp)
        #insertion_sort(array_tmp)
        answer.append(array_tmp[k-1])

    return answer

arr = [1,5,2,6,3,7,4]
cm = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
result = solution(arr, cm)
print(result)