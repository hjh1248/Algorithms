board = [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]
def solution(board):
    answer = 0
    newboard = [[0]*len(board[0]) for _ in range(len(board))]
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 1:
                for x in range(max(0, i-1), min(len(board), i+2)):
                    for y in range(max(0, j-1), min(len(board[0]), j+2)):
                        newboard[x][y] = 1
    for i in range(len(newboard)):
        for j in range(len(newboard[0])):
            if newboard[i][j] == 0:
                answer += 1    
    return answer
print(solution(board))