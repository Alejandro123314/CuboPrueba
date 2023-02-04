package globalStatsIO;

import io.github.fvarrui.globalstats.GlobalStats;

public class GlobalStat {

	GlobalStats client = new GlobalStats(clientId, clientSecret);
	String token = client.getAccessToken();
	System.out.println(token);
	
}
