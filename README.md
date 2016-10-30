# LazyFragment

Android class for lazy loading data to viewpager fragment.
Data will load when **onFirstVisible()** is calling.

##Usage:
```
class MyFragment extends LazyFragment {
  ...
  @Override
  public void onFirstVisible(){
    // load data to fragment  
  }
  
  @Override
  public void onVisibilityChange(boolean isVisible) {
    // catch visibility change  
  }
}
```
