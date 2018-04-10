package p8project.sw801.ui.AddEvent.addeventnest;

import android.os.Bundle;

import javax.inject.Inject;

import p8project.sw801.BR;
import p8project.sw801.R;
import p8project.sw801.databinding.ActivityAddEventNestBinding;
import p8project.sw801.ui.base.BaseActivity;

public class AddEventNest extends BaseActivity<ActivityAddEventNestBinding, AddEventNestViewModel> implements AddEventNestNavigator {
    @Inject
    AddEventNestViewModel mAddEventNestViewModel;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_event_nest;
    }

    @Override
    public AddEventNestViewModel getViewModel() {
        return mAddEventNestViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        //TODO: handle error
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_nest);
    }
}
