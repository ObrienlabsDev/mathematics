# matrix math without libraries

m1 = [[1,0,0],[0,1,0],[0,0,1]]
m2 = [[2,0,0],[0,0,0],[0,0,0]]


def add(a, b):
    m3 = [[0,0,0],[0,0,0],[0,0,0]]
    for i in range(len(a)):
        for j in range(len(a[i])):
            m3[i][j] = a[i][j] + b[i][j]
    return m3

def print_matrix(m):
    for row in m:
        print(row)

if __name__ == "__main__":
    m3 = add(m1, m2)
    print_matrix(m3)


