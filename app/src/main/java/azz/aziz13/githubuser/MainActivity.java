package azz.aziz13.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private UserAdapter adapter;
    private String[] datanama,perusahaan,follower,following,repositori,lokasi;
    private TypedArray avatar;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_user);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        datanama = getResources().getStringArray(R.array.username);
        perusahaan = getResources().getStringArray(R.array.company);
        avatar = getResources().obtainTypedArray(R.array.avatar);
        follower = getResources().getStringArray(R.array.followers);
        following = getResources().getStringArray(R.array.following);
        repositori = getResources().getStringArray(R.array.repository);
        lokasi = getResources().getStringArray(R.array.location);

        users = new ArrayList<>();

        for(int i = 0; i < datanama.length; i++){
            User user = new User();
            user.setAvatar(avatar.getResourceId(i, -1));
            user.setUsername(datanama[i]);
            user.setPerusahaan(perusahaan[i]);
            user.setFollower(follower[i]);
            user.setFolloweing(following[i]);
            user.setRepositori(repositori[i]);
            user.setLokasi(lokasi[i]);
            users.add(user);
        }
        adapter.setUsers(users);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(MainActivity.this, MainUsers.class);
                detailIntent.putExtra(MainUsers.EXTRA_USER, users.get(i));
                detailIntent.putExtra(RepoFragment.TOTAL_REPO, users.get(i));
                detailIntent.putExtra(MapsFragment.EXTRA_LOKASI, users.get(i));
                startActivity(detailIntent);
            }
        });
    }

}