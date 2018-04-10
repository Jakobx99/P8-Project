package p8project.sw801.ui.AddEvent.addeventhue;

import android.os.Bundle;

import javax.inject.Inject;

import p8project.sw801.BR;
import p8project.sw801.R;
import p8project.sw801.databinding.ActivityAddEventHueBinding;
import p8project.sw801.ui.base.BaseActivity;

public class AddEventHue extends BaseActivity<ActivityAddEventHueBinding, AddEventHueViewModel> implements AddEventHueNavigator {
    @Inject
    AddEventHueViewModel mAddEventHueViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_event_hue;
    }

    @Override
    public AddEventHueViewModel getViewModel() {
        return mAddEventHueViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        //TODO: handle error
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_hue);
    }
}
