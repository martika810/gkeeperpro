exports.config = {
  framework: 'jasmine',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  rootElement: '#taskApp',
  capabilities: {
      'browserName': 'chrome',
      'chromeOptions': {
          'args': ['disable-extensions', 'start-maximized', 'enable-crash-reporter-for-testing']
      },
      'loggingPrefs': {
          'browser': 'ALL'
      }
  },
  specs: ['test-task-panel.js']
}