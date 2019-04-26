package com.example.newsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import retrofit2.http.Url;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Article> articles;

    DataAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.article_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.setImageView(article.urlToImage);
        holder.titleView.setText(article.title);
        holder.authorView.setText(article.author);
        holder.dateView.setText(article.publishedAt);
        holder.contentView.setText(article.content);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView authorView, titleView, dateView, contentView;
        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.articleImage);
            authorView = view.findViewById(R.id.articleAuthor);
            titleView = view.findViewById(R.id.articleTitle);
            dateView = view.findViewById(R.id.articleDate);
            contentView = view.findViewById(R.id.articleContent);
        }

        public void setImageView(String imagePath){
            new AsyncTask<String, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(String... strings) {
                    String url = strings[0];
                    Bitmap image = null;
                    try {
                        InputStream in = new URL(url).openStream();
                        image = BitmapFactory.decodeStream(in);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    return image;
                }
                @Override
                protected void onPostExecute(Bitmap result){
                    imageView.setImageBitmap(result);
                }
            }.execute(imagePath);
        }
    }
}
