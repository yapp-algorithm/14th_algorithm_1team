def DFS(tickets, current_node, current_path, all_path) :
    current_path += str(' '.join(current_node)) + ' '

    if len(tickets) == 0 :
        all_path.append(current_path)
        return

    for ticket in tickets :
        if current_node[1] == ticket[0] :
            tickets_tmp = tickets[:]
            tickets_tmp.remove(ticket)
            DFS(tickets_tmp, ticket, current_path, all_path)

def solution(tickets) :
    all_path = []

    for ticket in tickets :
        if ticket[0] == 'ICN' :
            tickets_tmp = tickets[:]
            tickets_tmp.remove(ticket)
            DFS(tickets_tmp, ticket, '', all_path)

    result = []
    for path in all_path:
        tmp = []
        # print(path.split(' ')[:-1])
        s = path.split(' ')[:-1]
        for idx, w in enumerate(s):
            if idx % 2 == 0:
                tmp.append(w)
            elif idx == len(s) - 1:
                tmp.append(w)
        result.append(tmp)

    result.sort()

    return result[0]

#tickets = [['ICN', 'JFK'], ['HND', 'IAD'], ['JFK', 'HND']]
tickets = [['ICN', 'SFO'], ['ICN', 'ATL'], ['SFO', 'ATL'], ['ATL', 'ICN'], ['ATL', 'SFO']]
#tickets = [['ICN', 'AAA'], ['ICN', 'BBB'], ['BBB', 'ICN']]
print(solution(tickets))