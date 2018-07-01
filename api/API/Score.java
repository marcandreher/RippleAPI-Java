package API;

import java.net.MalformedURLException;
import java.net.URL;

import Main.Static;

public class Score {
	
	private Long id;
	private String beatmap_md5;
	private Long score;
	private Long max_combo;
	private Boolean full_combo;
	private Long mods;
	private Long count_300;
	private Long count_100;
	private Long count_50;
	private Long count_geki;
	private Long count_katu;
	private Long count_miss;
	private String time;
	private Long play_mode;
	private Long accuracy;
	private Long pp;
	private String rank;
	private Long completed;
	
	//JSONArray ("beatmap")
	private Long beatmap_id;
	private Long beatmapset_id;
	private String song_name;
	private Long ar;
	private Long od;
	private Long difficulty;
	private Long map_max_combo;
	private Long hit_length;
	private Long ranked;
	private Long ranked_status_frozen;
	private String latest_update;
	
	public Score(Long id, String beatmap_md5, Long score, 
			Long max_combo, Boolean full_combo
			, Long mods, Long count_300, Long count_100,
			Long count_50, Long count_geki, Long count_katu, Long count_miss
			,String time, Long play_mode, Long accuracy, Long pp, String rank, Long completed,Long beatmap_id,
			Long beatmapset_id, String song_name, Long ar, Long od, Long difficulty, Long map_max_combo,
			Long hit_length, Long ranked, Long ranked_status_frozen, String latest_update)  {
		
		this.id = id;this.beatmap_md5 = beatmap_md5;this.score = score;this.max_combo = max_combo;
		this.full_combo = full_combo;this.mods = mods;this.count_300 = count_300;this.count_100 = count_100;
		this.count_50 = count_50;this.count_geki = count_geki;this.count_katu = count_katu;this.count_miss = count_miss;
		this.time = time;this.play_mode = play_mode;this.accuracy = accuracy;this.pp = pp;this.rank = rank;
		this.completed = completed;this.beatmap_id = beatmap_id;this.beatmapset_id = beatmapset_id;
		this.song_name = song_name;this.ar = ar;this.od = od;this.difficulty = difficulty;this.map_max_combo = map_max_combo;
		this.hit_length = hit_length;this.ranked = ranked;this.ranked_status_frozen = ranked_status_frozen;this.latest_update = latest_update;
		
	}
	
	public Long getID() {
		return id;
	}
	public String getBeatmap_md5() {
		return beatmap_md5;
	}
	public Long getScore() {
		return score;
	}
	public Long getMax_Combo() {
		return max_combo;
	}
	public Boolean getFull_Combo() {
		return full_combo;
	}
	public Long getMods() {
		return mods;
	}
	public Long getCount_300() {
		return count_300;
	}
	public Long getCount_100() {
		return count_100;
	}
	public Long getCount_50() {
		return count_50;
	}
	public Long getCount_Geki() {
		return count_geki;
	}
	public Long getCount_Katu() {
		return count_katu;
	}
	public Long getCount_Miss() {
		return count_miss;
	}
	public String getTime() {
		return time;
	}
	public Long getPlay_Mode() {
		return play_mode;
	}
	public Long getaccuracy() {
		return accuracy;
	}
	public Long getPP() {
		return pp;
	}
	public String getRank() {
		return rank;
	}
	public Long getcompleted() {
		return completed;
	}
	public Long getbeatmap_id() {
		return beatmap_id;
	}
	public Long getbeatmapset_id() {
		return beatmapset_id;
	}
	public String getsong_name() {
		return song_name;
	}
	public Long getAR() {
		return ar;
	}
	public Long getOD() {
		return od;
	}
	public Long getdifficulty() {
		return difficulty;
	}
	public Long getmap_max_combo() {
		return map_max_combo;
	}
	public Long gethit_length() {
		return hit_length;
	}
	public Long getranked() {
		return ranked;
	}
	public Long getranked_status_frozen() {
		return ranked_status_frozen;
	}
	public String getlatest_update() {
		return latest_update;
	}
	
	public URL getBeatmap_Page() {
		try {
			return new URL("https://"+Static.server+"/b/"+this.getbeatmap_id());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
