import java.io.BufferedReader;
i rt java.io.IOException;

import java.io.InputStreamReader;

ava.uil.*;ava.io.*; Min {c voiden = Integer.parseIni

for (int i
    a[i] = Integer.parseInt(s[i]);

        int ans = 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            Arrays.sort(a);
            if (i == 1) {
                sum = a[i] + a[i - 1];
                ans += sum;
                continue;
            }
            sum += a[i];
            ans += sum;
        }
        System.out.println(ans);
        in.close();
    }
}
