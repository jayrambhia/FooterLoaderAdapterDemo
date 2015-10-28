## FooterLoaderAdapter

This is a demo project which shows how to use RecyclerView to create Infinite scrolling with loader
view as the footer. The demo shows how to write a generic RecyclerView Adapter to facilitate to any type
of the data.

Here's a quick demo of the app.

![demo gif](https://github.com/jayrambhia/FooterLoaderAdapterDemo/blob/master/demo.gif)

FooterLoaderAdapter is an abstract template class which extends `RecylcerView.Adapter<RecyclerView.ViewHolder>`.
It has following methods which user can use conveniently to create their own Recycler Adapter.

    public abstract long getYourItemId(int position);
    public abstract RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent);
    public abstract void bindYourViewHolder(RecyclerView.ViewHolder holder, int position);

This project also includes a RecyclerView ScrollListener which calls `onLoadMore()` when the recyclerview is
scrolled till the end. Once `onLoadMore()` is called, the app should call api to get more data. Meanwhile,
to show the loader as the footer, app must call, `FooterLoaderAdapter.showLoading(true)` and should also call
`notifyDataSetChanged()` to let the adapter know that it has to show the footer now.

Once the data is available, app should add the data to the adpater and call `FooterLoaderAdapter.showLoading(false)`
to hide the footer and `notifyDataSetChanged()` to let the adpater know that the data has changed.
