
exports.config = {
  framework: 'jasmine',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  rootElement: '#taskPanel',
  capabilities: {
      'browserName': 'chrome',
      'chromeOptions': {
          'args': ['disable-extensions', 'start-maximized', 'enable-crash-reporter-for-testing']
      },
      'loggingPrefs': {
          'browser': 'ALL'
      }
  },
  baseUrl: 'http://localhost:8090',
  specs: ['spec/test-*.js'],

}