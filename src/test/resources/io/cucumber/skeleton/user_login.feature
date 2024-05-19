@Login
Feature: User Login

  Scenario: Login dengan username dan password yang valid
    Given Pengguna berhasil mengakses website Swaglabs pada browser
    And Pengguna berada pada halaman login
    When Pengguna menginput username "standard_user" dan password "secret_sauce"
    And Pengguna menekan tombol login
    Then Login berhasil dan sistem menampilkan halaman dashboard yang berisi daftar katalog produk

  Scenario: Login hanya dengan mengisi username
    Given Pengguna berhasil mengakses website Swaglabs pada browser
    And Pengguna berada pada halaman login
    When Pengguna menginput username "standard_user"
    And Pengguna menekan tombol login
    Then Login gagal, current screen tetap berada pada halaman login, dan sistem menampilkan pesan error "You need Password!"
