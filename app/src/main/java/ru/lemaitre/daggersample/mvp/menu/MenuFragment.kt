package ru.lemaitre.daggersample.mvp.menu

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.lemaitre.daggersample.R
import ru.lemaitre.daggersample.mvp.get_storage.GetStorageFragment

class MenuFragment : Fragment(R.layout.fragment_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.getStorage).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_content, GetStorageFragment())
                .commit()
        }
    }
}