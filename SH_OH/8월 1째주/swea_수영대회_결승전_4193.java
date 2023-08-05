
package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class swea_수영대회_결승전_4193 {

    static class Node {
        int x;
        int y;
        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] Map = new int[15][15];
    static int[][] dist = new int[15][15];
    static int n, T;
    static int start_x, start_y, des_x, des_y;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int time;

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start_x, start_y));
        dist[start_x][start_y] = 0;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int cx = temp.x;
            int cy = temp.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 맵 밖이거나, 장애물인 곳 안감
                if (nx < 0 || ny < 0 || nx >= n || ny >= n
                        || Map[nx][ny] == 1) {
                    continue;
                }

                // 한 번도 안 간 곳이라면
                if (dist[nx][ny] == -1) {
                    // 그 곳이 소용돌이 라면
                    if (Map[nx][ny] == 2) {
                        if ( dist[cx][cy] % 3 == 0 ) {
                            dist[nx][ny] = dist[cx][cy] + 3;
                            q.add(new Node(nx, ny));
                        }
                        else if ( dist[cx][cy] % 3 == 1 ) {
                            dist[nx][ny] = dist[cx][cy] + 2;
                            q.add(new Node(nx, ny));
                        }
                        else if ( dist[cx][cy] % 3 == 2 ) {
                            dist[nx][ny] = dist[cx][cy] + 1;
                            q.add(new Node(nx, ny));
                        }
                    }
                    // 그 곳이 소용돌이가 아니면
                    else {
                        q.add(new Node(nx, ny));
                        dist[nx][ny] = dist[cx][cy] + 1;
                    }
                }
                // 이미 갔던 곳이라면 비교
                else if (dist[nx][ny] > dist[cx][cy])
                {
                    // 이미 갔던 곳이 소용돌이 라면?
                    if (Map[nx][ny] == 2) {
                        if ( dist[cx][cy] % 3 == 0 ) {
                            dist[nx][ny] = dist[cx][cy] + 3;
                            q.add(new Node(nx, ny));
                        }
                        else if ( dist[cx][cy] % 3 == 1 ) {
                            dist[nx][ny] = dist[cx][cy] + 2;
                            q.add(new Node(nx, ny));
                        }
                        else if ( dist[cx][cy] % 3 == 2 ) {
                            dist[nx][ny] = dist[cx][cy] + 1;
                            q.add(new Node(nx, ny));
                        }
                    }
                    // 소용돌이가 아니면
                    else {
                        q.add(new Node(nx,ny));
                        dist[nx][ny] = dist[cx][cy] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            des_x = Integer.parseInt(st.nextToken());
            des_y = Integer.parseInt(st.nextToken());

            // 입력 받기

            // 방문/거리 처리 배열 -1로 초기화
            for (int i = 0 ; i < n ; i ++)
                Arrays.fill(dist[i], -1);

            // bfs 시작
            bfs();

            System.out.printf("#%d %d\n", t+1, dist[des_x][des_y]);

        }
    }
}



