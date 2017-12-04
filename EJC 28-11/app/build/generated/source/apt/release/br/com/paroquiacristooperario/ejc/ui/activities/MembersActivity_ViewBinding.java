// Generated code from Butter Knife. Do not modify!
package br.com.paroquiacristooperario.ejc.ui.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import br.com.paroquiacristooperario.ejc.R;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MembersActivity_ViewBinding implements Unbinder {
  private MembersActivity target;

  @UiThread
  public MembersActivity_ViewBinding(MembersActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MembersActivity_ViewBinding(MembersActivity target, View source) {
    this.target = target;

    target.list = Utils.findRequiredViewAsType(source, R.id.listview, "field 'list'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MembersActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list = null;
  }
}
