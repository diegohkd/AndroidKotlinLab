package example.com.spinnerwithdisabledoptions

data class City(val name: String, val isEnabled: Boolean) {

    override fun toString(): String {
        return name
    }
}