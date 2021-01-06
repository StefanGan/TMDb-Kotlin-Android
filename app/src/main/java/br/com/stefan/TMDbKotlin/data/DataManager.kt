package br.com.stefan.TMDbKotlin.data;

import br.com.stefan.TMDbKotlin.data.network.ApiHelper
import br.com.stefan.TMDbKotlin.data.prefs.PreferencesHelper

interface   DataManager: PreferencesHelper, ApiHelper