package uniapply.com.daggerretrofit.Pojo;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Posts {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public String id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    public String title;
}
