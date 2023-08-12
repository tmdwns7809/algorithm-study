// 문제 : [백준] 2178번 - 미로 탐색

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    private int y;
    private int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }
}

public class Main {

    // 미로 크기, 결과
    public static int rowSize, colSize, result;

    // 도착점
    public static int endY, endX;

    // 미로
    public static int miro[][];

    // 델타
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 미로 탐색 메서드
    static void solve(int row, int col) {

        // 노드 넣을 큐 생성
        Queue<Node> queue = new LinkedList<Node>();

        // 시작 노드 삽입
        queue.offer(new Node(row,col));
        miro[row][col]+=1;

        // 미로 탐색하기
        while(!queue.isEmpty()) {

            // 탐색 노드 꺼내기
            Node curNode = queue.poll();

            // 네 방향 탐색
            for(int dir=0; dir<4; dir++) {

                int ny = dy[dir]+curNode.getY();
                int nx = dx[dir]+curNode.getX();

                // 범위 밖인 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 벽인 경우
                if(miro[ny][nx]!=1) continue;

                // 횟수 증가
                miro[ny][nx] = miro[curNode.getY()][curNode.getX()]+1;

                // 도착점인 경우
                if(endY==ny && endX==nx) {
                    result = miro[ny][nx];
                    return;
                }

                // 탐색 노드 큐에 추가
                queue.offer(new Node(ny,nx));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 미로 만들기
        miro = new int[rowSize][colSize];

        // 미로 도착점 설정
        endY = rowSize-1;
        endX = colSize-1;

        // 미로 정보 입력
        for(int i=0; i<rowSize; i++) {
            String line = br.readLine();
            for(int j=0; j<colSize; j++) {
                miro[i][j] = line.charAt(j)-'0';
            }
        }

        // 미로 탐색
        result = rowSize*colSize;
        solve(0,0);

        // 결과 출력
        System.out.println(result-1);
    }
}