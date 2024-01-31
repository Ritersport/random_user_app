package nsu.ritersport.focususerrs.presentation.user_datails

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import nsu.ritersport.focususerrs.databinding.FragmentUserDetailsBinding
import nsu.ritersport.focususerrs.domain.model.Gender.Companion.asString
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.presentation.base.view.BaseFragment
import nsu.ritersport.focususerrs.presentation.base.view.viewBinding


@AndroidEntryPoint
class DetailsFragment : BaseFragment() {
    override val binding by viewBinding { inflater, container ->
        FragmentUserDetailsBinding.inflate(inflater, container, false)
    }
    override val viewModel: DetailsViewModel by viewModels()

    private lateinit var userId: String
    private lateinit var user: User


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userId = requireArguments().getString(ARG_KEY, "")
        setupVmObservers()
        setupViewListeners()
        viewModel.loadUser(userId)
    }

    private fun setupVmObservers() {
        viewModel.user.observe(viewLifecycleOwner, ::onUserLoaded)
    }

    private fun setupViewListeners() {
        setupEmailHandler()
        setupPhoneHandler()
    }

    private fun setupEmailHandler() {
        binding.email.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_APP_EMAIL)
                this.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    requireContext(),
                    "There is no email client installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    private fun setupPhoneHandler() {
        binding.phoneText.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:%s".format(user.phone))
                this.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    requireContext(),
                    "There is no contacts client installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }



    private fun onUserLoaded(user: User) {
        this.user = user
        with(binding) {
            nameText.text = user.name.toString()
            age.text = "%s y.o.".format(user.age)
            gender.text = user.gender.asString()
            addressText.text = user.location.addressString()
            email.text = user.email
            phoneText.text = user.phone
            phoneText.paintFlags = phoneText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            cellText.text = user.cell
            cellText.paintFlags = cellText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            registeredText.text = "Registered %s year(s) ago".format(user.registered)
            image.setImageURI(user.picture)
        }
    }

    companion object{
        val ARG_KEY = "nav_key"
    }
}