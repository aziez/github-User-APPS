package azz.aziz13.githubuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class UserAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<User> users = new ArrayList<>();

    void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User) getItem(i);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName,txtPerusahaan,txtFollowing,txtFollower;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_username);
            txtPerusahaan = view.findViewById(R.id.txt_perusahaan);
            imgPhoto = view.findViewById(R.id.avatar);
        }

        void bind(User user) {
            txtName.setText(user.getUsername());
            txtPerusahaan.setText(user.getPerusahaan());
            imgPhoto.setImageResource(user.getAvatar());
        }
    }
}