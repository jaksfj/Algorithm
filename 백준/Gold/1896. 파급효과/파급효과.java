import java.io.*;
import java.util.*;

public class Main {
    // 1. dfs 통해서 descr 탐색하면서 서로 방향을 가리키는지 확인하기
    // 2. set 에서 탐색했던 요소들을 저장 : set.size() 구하는용 + 해당 폴리노미오에서 구한 가장 큰 수(max)를 구해서 서로 같은지 확인
    // 3. 북동남서로 해당 수 만큼 떨어진 곳 사이에 해당 수가 없는지 확인하기

    static int R, C;
    static int[][] puzzle;
    static int[][] descr;
    static boolean[][] visited;

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static final int[] bit = {1, 2, 4, 8};
    static final int[] opp = {4, 8, 1, 2};

    static boolean valid;

    // 폴리오미노 검증용
    static Set<Integer> set;
    static int cnt, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            puzzle = new int[R + 1][C + 1];
            descr = new int[R + 1][C + 1];
            visited = new boolean[R + 1][C + 1];
            valid = true;

            // 퍼즐 숫자 입력
            for (int i = 1; i <= R; i++) {
                String s = br.readLine();
                for (int j = 1; j <= C; j++) {
                    puzzle[i][j] = s.charAt(j-1)-'0';
                }
            }

            // descr 입력
            for (int i = 1; i <= R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= C; j++) {
                    descr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 1,2) dfs 하면서 1,2 검증
            for (int i = 1; i <= R && valid; i++) {
                for (int j = 1; j <= C && valid; j++) {
                    if (!visited[i][j]) {
                        set = new HashSet<>();
                        cnt = 0;
                        max = 0;
                        dfs(i, j);

                        // 폴리오미노 내부 숫자 (1~N) 조건
                        if (cnt != max || set.size() != cnt) {
                            valid = false;
                            break;
                        }
                    }
                }
            }
            if(!valid){
                System.out.println("invalid");
                continue;
            }

            // 3) 행열 거리 규칙 검사
            for (int i = 1; i <= R && valid; i++) {
                for (int j = 1; j <= C && valid; j++) {
                    checkDistance(i, j);
                }
            }

            System.out.println(valid ? "valid" : "invalid");
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;
        set.add(puzzle[x][y]);
        max = Math.max(max, puzzle[x][y]);

        int present = descr[x][y];

        // descr 양방향 검증
        for (int dir = 0; dir < 4; dir++) {
            if ((present & bit[dir]) != 0) { // 가리키는 방향 찾기
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 경계 벗어나면 invalid
                if (nx < 1 || ny < 1 || nx > R || ny > C) {
                    valid = false;
                    return;
                }

                // 서로 반대 방향 비트 아예 없으면 invalid
                if ((descr[nx][ny] & opp[dir]) == 0) {
                    valid = false;
                    return;
                }

                // 검증 마친 후 같은 폴리오미노면 탐색
                if (!visited[nx][ny]) {
                    dfs(nx, ny);
                    if (!valid) {
                        return;
                    }
                }
            }
        }
    }

    // 3) 행열 거리 규칙 검사
    static void checkDistance(int x, int y) {
        int n = puzzle[x][y];

        // 4방향 (북동남서)
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                // 범위 벗어나면 그 방향은 더 볼 필요 없음
                if (nx < 1 || ny < 1 || nx > R || ny > C) {
                    break;
                }

                // 같은 숫자가 n칸 이내에 있으면 invalid
                if (puzzle[nx][ny] == n) {
                    valid = false;
                    return;
                }
            }
        }
    }
}
